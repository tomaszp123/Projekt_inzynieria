package pl.spio.i18n;

import java.io.Serializable;
import java.security.Principal;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import pl.spio.ecommerce.account.User;
import pl.spio.ecommerce.account.UserController;


@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {
	@EJB
	private UserController userController;
	private String username;
	private String password;
	private User user;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		if (user == null) {
			Principal principal = FacesContext.getCurrentInstance()
					.getExternalContext().getUserPrincipal();
			if (principal != null) {
				user = userController.findUser(principal.getName());
			}
		}
		return user;
	}

	public boolean isUserLoggedIn() {
		return getUser() != null;
	}

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			request.login(username, password);
			getUser();
		} catch (ServletException e) {
			FacesMessage message = new FacesMessage(getText("unknown.login"));
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("loginForm:username", message);
			return "";
		}
		return "start/index.xhtml?faces-redirect=true";
	}

	protected String getText(String key) {
		String text = null;
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(
					"pl.spio.i18n.Text", FacesContext.getCurrentInstance()
							.getViewRoot().getLocale());
			text = bundle.getString(key);
		} catch (Exception e) {
			text = "???" + key + "???";
		}
		return text;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		user = null;
		return "logout";
	}
}