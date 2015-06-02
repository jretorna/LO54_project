package fr.utbm.concentrateur.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/collect")
public class SpringCollectBean {

	
	@GET
	public String getReleve() {
		
		/*String uploadedFileLocation = System.getProperty("catalina.home")+ File.pathSeparator+ fileDetail.getFileName();
		 
		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);
 
		String output = "File uploaded to : " + uploadedFileLocation;*/
		
		return "get releve" ;//MediaType.APPLICATION_XML+" "+releve.toString();
	}
	
	// save uploaded file to new location
	/*	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {
	 
			try {
				OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
				int read = 0;
				byte[] bytes = new byte[1024];
	 
				out = new FileOutputStream(new File(uploadedFileLocation));
				while ((read = uploadedInputStream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				out.flush();
				out.close();
			} catch (IOException e) {
	 
				e.printStackTrace();
			}
	 
		}*/
}
