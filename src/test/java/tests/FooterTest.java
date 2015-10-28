package tests;

import static org.junit.Assert.*;

import org.testng.annotations.Test;

import driverLogic.TestBase;

public class FooterTest extends TestBase {
	
	@Test
	public void portalsNewsOnFacebookLinkTest() throws Exception{
		
		assertTrue(app.getNavigationHelper().isPortalsNewsOnFacebookLinkDisplayed());
		}
	@Test
	public void noSuchServicesLinkTest() throws Exception{
		
		assertTrue(app.getNavigationHelper().isNoSuchServicesLinkDisplayed());
		}
	@Test
	public void errorOrABugOnThePortalLinkTest() throws Exception{
		
		assertTrue(app.getNavigationHelper().isErrorOrABugOnThePortalLinkDisplayed());
		}
	@Test
	public void joinOnGitHubLinkTest() throws Exception{
		
		assertTrue(app.getNavigationHelper().isJoinOnGitHubLinkDisplayed());
		}
	@Test
	public void commentsAndOpportunitiesLinkTest() throws Exception{
		
		assertTrue(app.getNavigationHelper().isCommentsAndOpportunitiesLinkDisplayed());
		}
}
