package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.NoticeService;
import board.model.vo.Board;

/**
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet("/nup")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 5;
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "files/board/notice";
			MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			String file = mrequest.getFilesystemName("file");
			String ofile = mrequest.getParameter("ofile");
			String rfile = mrequest.getParameter("refile");
			String refile = "";
			
			if(file != null && file.equals(ofile) != true) {
				new File(savePath + rfile).delete();
				
				long time = System.currentTimeMillis();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				
				refile = sdf.format(new Date(time)) + "." + ofile.substring(ofile.lastIndexOf(".") + 1);
				
				FileInputStream fr = null;
				FileOutputStream os = null;
				byte[] readText = new byte[1024];
				
				File originFile = new File(savePath + ofile);
				File reFile = new File(savePath + rfile);
				
				if(!originFile.renameTo(reFile)) {
					fr = new FileInputStream(originFile);
					os = new FileOutputStream(reFile);
					int result = 0;
					while((result = fr.read(readText, 0, readText.length)) != -1) {
						os.write(readText, 0, result);
						os.flush();
					}
					fr.close();
					os.close();
					
				}
			}
			int bnum = Integer.parseInt(mrequest.getParameter("num"));
			String btitle = mrequest.getParameter("ntitle");
			String bcontent = mrequest.getParameter("ncontent");
			int currentPage = Integer.parseInt(mrequest.getParameter("page"));
			
			Board b = new Board(bnum,btitle,bcontent, file, refile);
			NoticeService nservice = new NoticeService();
			int result = 0;
			result = nservice.updateNotice(b);
			if(result > 0) {
				response.sendRedirect("/diedie/ndetail?bnum="+bnum+"&page="+currentPage);
			}
			
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
