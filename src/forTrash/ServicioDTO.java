package forTrash;

import java.time.LocalDateTime;
import java.util.List;

import com.wollcorp.TEMP.PuertoDTO;

public class ServicioDTO {
	
	private String coServ;
	private String noServ;
	private String fgActi;
	private String usCreaServ;
	private LocalDateTime feCreaServ;
	private String usModiServ;
	private LocalDateTime feModiServ;
	private List<PuertoDTO> puertos;
	private String fgFarEast;
	
	public String getCoServ() {
		return coServ;
	}
	public void setCoServ(String coServ) {
		this.coServ = coServ;
	}
	public String getNoServ() {
		return noServ;
	}
	public void setNoServ(String noServ) {
		this.noServ = noServ;
	}
	public String getFgActi() {
		return fgActi;
	}
	public void setFgActi(String fgActi) {
		this.fgActi = fgActi;
	}
	public String getUsCreaServ() {
		return usCreaServ;
	}
	public void setUsCreaServ(String usCreaServ) {
		this.usCreaServ = usCreaServ;
	}
	public LocalDateTime getFeCreaServ() {
		return feCreaServ;
	}
	public void setFeCreaServ(LocalDateTime feCreaServ) {
		this.feCreaServ = feCreaServ;
	}
	public String getUsModiServ() {
		return usModiServ;
	}
	public void setUsModiServ(String usModiServ) {
		this.usModiServ = usModiServ;
	}
	public LocalDateTime getFeModiServ() {
		return feModiServ;
	}
	public void setFeModiServ(LocalDateTime feModiServ) {
		this.feModiServ = feModiServ;
	}
	public List<PuertoDTO> getPuertos() {
		return puertos;
	}
	public void setPuertos(List<PuertoDTO> puertos) {
		this.puertos = puertos;
	}
	public String getFgFarEast() {
		return fgFarEast;
	}
	public void setFgFarEast(String fgFarEast) {
		this.fgFarEast = fgFarEast;
	}
	

}
