package service.qna.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.qna.model.service.QNAService;
import service.qna.model.vo.QNA;

/**
 * Servlet implementation class QNAModifyServlet
 */
@WebServlet("/qmodify")
public class QNAModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 11111111115L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maxSize = 1024 * 1024 * 10;
		RequestDispatcher view = null;
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("view/service/serviceError.jsp");
			request.setAttribute("message", "게시글 작성 오류");
			view.forward(request, response);
		}
	
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "files/board/service";
	
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "utf-8",
				new DefaultFileRenamePolicy());
		
		QNA qna = new QNA();
		qna.setqNo(Integer.parseInt(request.getParameter("qno")));
		qna.setqTitle(multi.getParameter("qtitle"));
		qna.setContents(multi.getParameter("qcontent"));
		qna.setUserId(multi.getParameter("qwriter"));
		qna.setPwd(multi.getParameter("qpwd"));
		qna.setCategory(multi.getParameter("qcategory"));
		
		String original = null;
		Enumeration files = multi.getFileNames();
		int count = 0;
		
		while(files.hasMoreElements()) {
			String fName = (String)files.nextElement();
			original = multi.getOriginalFileName(fName);
			
			if (original != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String refName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + count + "."
						+ original.substring(original.lastIndexOf(".") + 1);

				File originFile = new File(savePath + "\\" + original);
				File renameFile = new File(savePath + "\\" + refName);

				if (!originFile.renameTo(renameFile)) {
					int read = -1;
					byte[] buf = new byte[1024];

					FileInputStream fin = new FileInputStream(originFile);
					FileOutputStream fout = new FileOutputStream(renameFile);

					while ((read = fin.read(buf, 0, buf.length)) != -1) {
						fout.write(buf, 0, read);
					}
					fin.close();
					fout.close();
					originFile.delete();
				}
				switch(count) {
				case 0: qna.setFile1(original);
						qna.setRefile1(refName);
						break;
				case 1: qna.setFile2(original);
						qna.setRefile2(refName);
						break;
				case 2: qna.setFile3(original);
						qna.setRefile3(refName);
						break;
				}
			count++;
				
			}
		}
		response.setContentType("text/html; charset=utf-8");
		if (new QNAService().modifyBoard(qna) > 0) {
			response.sendRedirect("/diedie/qdetail?qno=" + qna.getqNo() + "&page=" + currentPage);
		} else {
			view = request.getRequestDispatcher("view/service/serviceError.jsp");
			request.setAttribute("message", "게시글 수정 실패");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
