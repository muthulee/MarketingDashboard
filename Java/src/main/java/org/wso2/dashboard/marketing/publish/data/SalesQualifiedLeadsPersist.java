package org.wso2.dashboard.marketing.publish.data;

import org.wso2.dashboard.marketing.client.WSO2MarketingDashboardDataServiceStub;
import org.wso2.dashboard.marketing.model.processeddata.RegionCount;

import java.rmi.RemoteException;
import java.util.List;

public class SalesQualifiedLeadsPersist implements Leads{

	@Override public void insertToWeeklyDB(WSO2MarketingDashboardDataServiceStub stub, String startDate, String endDate,
	                                       List<RegionCount> regionCountList) throws RemoteException {
		WSO2MarketingDashboardDataServiceStub.InsertSalesQualifiedLeadsPerWeek
				request = new WSO2MarketingDashboardDataServiceStub.InsertSalesQualifiedLeadsPerWeek();

		request.setStart_date(startDate);
		request.setEnd_date(endDate);
		request.setTotal_users(regionCountList.get(0).getNoOfUsers());
		request.setEu_users(regionCountList.get(1).getNoOfUsers());
		request.setNa_users(regionCountList.get(2).getNoOfUsers());
		request.setRow_users(regionCountList.get(3).getNoOfUsers());
		request.setUnclassified_users(regionCountList.get(4).getNoOfUsers());

		stub.insertSalesQualifiedLeadsPerWeek(request);
	}

	@Override public void insertToQuarterlyDB(WSO2MarketingDashboardDataServiceStub stub, String year, int quarter,
	                                          List<RegionCount> regionCountList) throws RemoteException {

		WSO2MarketingDashboardDataServiceStub.InsertSalesQualifiedLeadsPerQuarter
				request = new WSO2MarketingDashboardDataServiceStub.InsertSalesQualifiedLeadsPerQuarter();

		request.setYear(year);
		request.setQuarter(quarter);
		request.setTotal_users(regionCountList.get(0).getNoOfUsers());
		request.setEu_users(regionCountList.get(1).getNoOfUsers());
		request.setNa_users(regionCountList.get(2).getNoOfUsers());
		request.setRow_users(regionCountList.get(3).getNoOfUsers());
		request.setUnclassified_users(regionCountList.get(4).getNoOfUsers());

		stub.insertSalesQualifiedLeadsPerQuarter(request);
	}

	@Override public void insertToYearlyDB(WSO2MarketingDashboardDataServiceStub stub, String year,
	                                       List<RegionCount> regionCountList) throws RemoteException {

		WSO2MarketingDashboardDataServiceStub.InsertSalesQualifiedLeadsPerYear
				request = new WSO2MarketingDashboardDataServiceStub.InsertSalesQualifiedLeadsPerYear();

		request.setYear(year);
		request.setTotal_users(regionCountList.get(0).getNoOfUsers());
		request.setEu_users(regionCountList.get(1).getNoOfUsers());
		request.setNa_users(regionCountList.get(2).getNoOfUsers());
		request.setRow_users(regionCountList.get(3).getNoOfUsers());
		request.setUnclassified_users(regionCountList.get(4).getNoOfUsers());

		stub.insertSalesQualifiedLeadsPerYear(request);
	}
}
