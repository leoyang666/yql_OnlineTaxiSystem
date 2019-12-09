package cn.edu.zjut.service;

import java.util.Iterator;
import java.util.List;

import cn.edu.zjut.dao.IOrderDAO;
import cn.edu.zjut.po.Order;

public class OrderService implements IOrderService {
	private IOrderDAO orderDAO=null;

	public OrderService() {
		System.out.println("create OrderService.");
	}
	
	public void save(Order transientInstance) {
		System.out.println("execute--save()--method.");
		orderDAO.save(transientInstance);
	}
	//����Ϊ���ľ�γ��
	public List all(String longitude,String latitude) {
		/*��֪����������ľ��ȡ�γ�ȣ���X1,Y1), (X2,Y2)������X1,X2Ϊ���ȣ�Y1,Y2Ϊγ�ȣ�
		�Ӽ��������Ҫת��Ϊ���ȣ�*3.1415926/180��	
		����뾶ΪR=6371.0 km
		���������d=R*arcos[cos(Y1)*cos(Y2)*cos(X1-X2)+sin(Y1)*sin(Y2)]
		*/
		System.out.println("execute--all()--method.");
		Double PI=Math.PI;
		Double PK=180/PI;
		List temp=orderDAO.all();
		Iterator<Order> it=temp.iterator();
		while(it.hasNext()) {
			Order t1=it.next();
			String location=t1.getStart();
			String []loc=location.split(",");
			double distance;
			double lon[]=new double[2];
			double lat[]=new double[2];
			lon[0]=Double.parseDouble(longitude)/PK;
			lat[0]=Double.parseDouble(latitude)/PK;
			lon[1]=Double.parseDouble(loc[0])/PK;
			lat[1]=Double.parseDouble(loc[1])/PK;
			//distance=Math.sqrt((lon[0]-lon[1])*(lon[0]-lon[1])+(lat[0]-lat[1])*(lat[0]-lat[1]));
			double tt1=Math.cos(lon[0])*Math.cos(lon[1])*Math.cos(Math.abs(lat[0]-lat[1]));
			double tt2=Math.sin(lon[0])*Math.sin(lon[1]);
			distance=Math.acos(tt1+tt2)*6371.0;//��λ��km
			if(distance>10) {
				it.remove();
			}
		}
		//���ؾ���С��10km�ĳ���
		return temp;
	}
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		System.out.println("create orderDAO");
		this.orderDAO = orderDAO;
	}
}
