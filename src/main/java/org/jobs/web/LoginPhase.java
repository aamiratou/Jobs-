package org.jobs.web;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;
import org.springframework.security.BadCredentialsException;
import org.springframework.security.ui.AbstractProcessingFilter;

public class LoginPhase implements PhaseListener {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginPhase.class);

	@Override
	public void beforePhase(PhaseEvent arg0) {
		Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
		        AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);

		if (e instanceof BadCredentialsException) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY, null);
			log.error("--------------------- error auth");
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getRemoteUser();
	}

	@Override
	public void afterPhase(PhaseEvent arg0) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
