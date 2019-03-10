package board.controller;

import java.io.ByteArrayOutputStream;
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

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.NoticeService;
import board.model.vo.Board;




/**
 * Servlet implementation class NoticeWriterServlet
 */
@WebServlet("/nwriter")
public class NoticeWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int maxSize = 1024 * 1024 * 5;
			
			RequestDispatcher view = null;
				if(!ServletFileUpload.isMultipartContent(request)) {
					view = request.getRequestDispatcher("views/notice/noticeError.jsp");
					request.setAttribute("message", "공지사항 작성 오류 ...");
					view.forward(request, response);
				}
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "files/board/notice";
			MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			Board b = new Board();
			b.setbTtitle(mrequest.getParameter("ntitle"));
			b.setUserId(mrequest.getParameter("nwriter"));
			b.setContent(mrequest.getParameter("ncontent"));
			String realFile = mrequest.getFilesystemName("file1");
			b.setFile1(realFile);
			
			if( realFile != null) {
				SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmmss");
				String copyFile = sim.format(new java.sql.Date(System.currentTimeMillis())) +"."+realFile.substring(realFile.lastIndexOf(".") + 1);
				
				File realf = new File(savePath +"\\"+realFile);
				File copyf = new File(savePath +"\\"+copyFile);
				
				if(!realf.renameTo(copyf)) {
					int read = -1;
					byte[] buf = new byte[1024];
					
					FileInputStream fin = new FileInputStream(realf);
					FileOutputStream fout = new FileOutputStream(copyf);
					
					while((read = fin.read(buf,0,buf.length)) != -1) {
						fout.write(buf, 0, read);
					}
					
					fin.close();
					fout.close();
					realf.delete();
									
				}
				
				b.setFile1(realFile);
				b.setRefile1(copyFile);
				
			}
			
			response.setContentType("text/html; charset=utf-8");
			
			if(new NoticeService().insertNotice(b) > 0) {
				response.sendRedirect("/diedie/nlist?page=1");
			} else {
				view = request.getRequestDispatcher("view/board/boardError.jsp");
				request.setAttribute("message", "공지사항 등록 실패!");
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
