package fr.minemodding.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class File {
	
	public static void download(URL url) throws IOException {
		HttpURLConnection uc;
		InputStream in;
		String FileName;
		FileOutputStream WritenFile;
		byte[] buffer;
		int l;
		
		uc = (HttpURLConnection) url.openConnection();
		int FileLenght = uc.getContentLength();
		if (FileLenght == -1) {
			throw new IOException("Fichier non valide.");
		}
		in = uc.getInputStream();
		FileName = url.getFile();
		FileName = FileName.substring(FileName.lastIndexOf('/') + 1);
		WritenFile = new FileOutputStream(FileName);
		buffer = new byte[1024];
		l = in.read(buffer);
		while(l>0)
		{
		WritenFile.write(buffer, 0, l);
		l = in.read(buffer);
		}
		WritenFile.flush();
		WritenFile.close();
	}
}
