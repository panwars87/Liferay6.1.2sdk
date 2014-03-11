/**
 * 
 */
package com.ys.events.training;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.util.PortalUtil;

/**
 * @author shashantp
 *
 */
public class CustomLandingPage extends Action{

	private static final String DEFAULT_LANDING_PAGE_PATH = "default.landing.page.path";
	private static Log _log = LogFactoryUtil.getLog(CustomLandingPage.class);
	private static String userCustomField = "landingSite";
	private static String siteCustomField = "landingPage";
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
		throws ActionException {

		try {
			doRun(request, response);
		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

	protected void doRun(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		System.out.println("## My custom login action ##");
		
		long companyId = PortalUtil.getCompanyId(request);
		String path = PrefsPropsUtil.getString(companyId, PropsKeys.DEFAULT_LANDING_PAGE_PATH);
		User loggedInUser = PortalUtil.getUser(request);
		PermissionChecker permissionchecker = PermissionCheckerFactoryUtil.getPermissionCheckerFactory().create(loggedInUser);
		PermissionThreadLocal.setPermissionChecker(permissionchecker);
		
		String userLandingSite=checkUserCustomField(loggedInUser);
		List<Group> mySites = loggedInUser.getMySites(false, 10);
		LastPath lastPath = null;
		
		if(Validator.isNotNull(mySites)){
			if(Validator.isNotNull(userLandingSite)){
				for(Group site : mySites){
					if(userLandingSite.equalsIgnoreCase(site.getName())){
						if (site.hasPrivateLayouts()) {
							// go there instead
							String siteFriendlyURL = site.getFriendlyURL();
							String myPath = "/" + loggedInUser.getLocale().getLanguage() + "/group" + siteFriendlyURL;
							System.out.println("Custom path is : "+myPath);
							lastPath = new LastPath(StringPool.BLANK, myPath);
						}
					}
				}
			}else{
				String siteDefaultPage=checkSiteCustomField(mySites.get(0));
				if(("private").equalsIgnoreCase(siteDefaultPage)){
					if(mySites.get(0).hasPrivateLayouts()){
						String siteFriendlyURL = mySites.get(0).getFriendlyURL();
						String myPath = "/" + loggedInUser.getLocale().getLanguage() + "/group" + siteFriendlyURL;
						System.out.println("Custom path is : "+myPath);
						lastPath = new LastPath(StringPool.BLANK, myPath);
					}
				}else if(("public").equalsIgnoreCase(siteDefaultPage)){
					String siteFriendlyURL = mySites.get(0).getFriendlyURL();
					String myPath = "/" + loggedInUser.getLocale().getLanguage() + "/web" + siteFriendlyURL;
					System.out.println("Custom path is : "+myPath);
					lastPath = new LastPath(StringPool.BLANK, myPath);
				}
			}
		}else{
			lastPath = new LastPath(StringPool.BLANK, path);
		}
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute(WebKeys.LAST_PATH, lastPath);
		
		// The commented code shows how you can programmaticaly set the user's
		// landing page. You can modify this class to utilize a custom algorithm
		// for forwarding a user to his landing page. See the references to this
		// class in portal.properties.

		/*Map<String, String[]> params = new HashMap<String, String[]>();

		params.put("p_l_id", new String[] {"1806"});

		LastPath lastPath = new LastPath("/c", "/portal/layout", params);

		session.setAttribute(WebKeys.LAST_PATH, lastPath);*/
	}
	
	private static String checkUserCustomField(User loggedInUser){
		String[] userLandingSite=null;
		if(loggedInUser.getExpandoBridge().hasAttribute(userCustomField)){
			userLandingSite=(String[]) loggedInUser.getExpandoBridge().getAttribute(userCustomField,false);
			System.out.println("Value of user custom attribute is : "+userLandingSite.length);
		}
		if(Validator.isNull(userLandingSite)){
			return null;
		}
		return userLandingSite[0];
	}
	
	private static String checkSiteCustomField(Group mySite){
		String siteDefaultPage=(String)mySite.getExpandoBridge().getAttribute(siteCustomField,false);
		System.out.println("Site custom attribute is : "+ siteDefaultPage);
		return siteDefaultPage;
	}

}
