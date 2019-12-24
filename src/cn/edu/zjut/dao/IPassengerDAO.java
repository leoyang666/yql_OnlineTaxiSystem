package cn.edu.zjut.dao;

import java.util.ArrayList;

import cn.edu.zjut.po.Driver;
import cn.edu.zjut.po.Order;
import cn.edu.zjut.po.Passenger;

public interface IPassengerDAO {
	public void save(Passenger transientInstance);
	public Passenger findbyaccount(Passenger transientInstance);
	public Passenger findbyId(int id);

	public void update(Passenger passenger);//���ĳ˿���Ϣ
	public Passenger select(Passenger passenger);//��ѯ������Ϣ
	public Driver driverInformation(Order order);//��ȡ���ն�����˾����Ϣ
	public ArrayList<Order> allOrder(Passenger passenger);//�鿴���ж���
	
	public void addOrder(Order order);//�µ�
	public void deleteOrder(Order order);//ɾ������
	public void estimate(Driver driver);//����
	public void pay(Passenger passenger);//֧��
	
}
