package it.unical.ingsw.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;


@WebServlet("/UploadFoto")
public class UploadFoto extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String base64 = request.getParameter("temp");
		//System.out.println(base64.split(",")[1]);
		//System.out.println(request.getRealPath(request.getServletPath()));
		convertiImmagine(base64);
		
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		
		
	}
	
	public void convertiImmagine(String base64) {
		
		String[] strings = base64.split(",");
        String extension;
        switch (strings[0]) {//check image's extension
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default://should write cases for more images types
                extension = "jpg";
                break;
        }
		

		byte[] data = Base64.getMimeDecoder().decode(strings[1]);
		
		Path relativePath = Paths.get("GymSystemAAA/WebContent/immagini");
		Path absolutePath = relativePath.toAbsolutePath();
		//System.out.println("Current relative path is: " + absolutePath.toString());
		//File sad = new File(".");
		System.out.println(absolutePath);
		
		
		  ByteArrayInputStream bis = new ByteArrayInputStream(data);
	      BufferedImage bImage2;
		try {
			bImage2 = ImageIO.read(bis);
			//L'absolute path non corrisponde alla cartella immagini che usiamo e quindi non
			//riusciamo a creare la foto per riutilizzarla 
			ImageIO.write(bImage2, extension, new File(absolutePath+"/output."+extension) );
			System.out.println("image created");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Couldn't write to file...");
		}
	     
	      
		
	/*
		//System.out.println(new File(".").getAbsolutePath());
		InputStream input = new ByteArrayInputStream(data);
		try(OutputStream output = new FileOutputStream(absolutePath.toString() + "/a." + extension))
		{
			   output.write(data);
			   IOUtils.copy(input, output);
			}
			catch (Exception e) 
			{
			   System.err.println("Couldn't write to file...");
			}
		*/
	}

	
	
	
	

}
