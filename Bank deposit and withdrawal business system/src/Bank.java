import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPasswordField;

public class Bank {
	Scanner input = new Scanner(System.in);
	List<User> userList = new ArrayList<User>();
	List<Admin> adminList = new ArrayList<Admin>();
	
	public void ShowMenu(){		        
		System.out.println("-------��ӭ�����ȡ��ҵ��ϵͳ-------");
	    System.out.println("1-����ϵͳ����Ա��ϵͳ");
	    System.out.println("2-�����ȡ����ϵͳ");
	    System.out.println("3-�˳�");
	    int choice = 0;  
        do{
        	System.out.println("����������Ҫ���еĲ�����");
            choice = input.nextInt(); 
            switch(choice){
                case 1:
                	Administrator();
                    break;
                case 2:
                	BusinessSystem();
                    break;
                case 3:
                	 System.out.println("��л����ʹ��,��ӭ�´ι���!");
                    break;
                default:
                    System.out.println("û������Ҫ�ķ�����Ŀ,����������!");
            }    
            if(choice == 3){
                break; 
            }
        }
        while(choice != 0);
    }

	public void Administrator() {
		
		System.out.print("���������Ա�û���:");
        String adminName = input.next();
        Admin admin = IsAdmin(adminName);
        if(admin == null){    
            System.out.println("�ù���Ա������!");
            return;
        }
        
        System.out.print("���������Ա����:");
        String password = input.next();
        if(!admin.password.equals(password)){
            System.out.println("��������������!");
            return;
        }
        System.out.println("******��ӭ����ϵͳ����Ա��******");
	    System.out.println("1-��������˺���Ϣ");
	    System.out.println("2-ɾ�������˺���Ϣ");
	    System.out.println("3-������ҳ��");
	    int choice = 0;  
        do{
        	System.out.println("����������Ҫ���еĲ�����");
            choice = input.nextInt(); 
            switch(choice){
                case 1:
                	AddBankAccount();
                    break;
                case 2:
                	DeleteBankAccount();
                    break;
                case 3:
                	ShowMenu();
                    break;
                default:
                    System.out.println("û������Ҫ�ķ�����Ŀ,����������!");
            }    
            if(choice == 3){
                break; 
            }
        }
        while(choice != 0);
	}
	
	public void AddBankAccount() {
		User u = new User();
		
        System.out.print("��������Ҫ��ӵ������˺�:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("�����˺������ʽ����,����������!");
			return;
		}
        User user = IsUser(account);
        if(user != null){    
            System.out.println("���˺��Ѵ���!");
            return;
        }else {
			u.setAccount(account);
		}
        System.out.print("������������:");
        String password = input.next();
        System.out.println("����ȷ������:");
        String password1 = input.next();
        if(!password.equals(password1)){
            System.out.println("�������������벻һ��!");
            return;
        }else {
            u.setPassword(password);
		}
        
        System.out.print("�����������֤��:");
        String id = input.next();
        u.setId(id);
        System.out.print("���������û���:");
        String userName = input.next();
        u.setUserName(userName);
        System.out.print("���������ͥסַ:");
        String address = input.next();
        u.setAddress(address);
        System.out.print("������������:");
        int money = input.nextInt();
        u.setMoney(money);
        userList.add(u);
        System.out.println("�����˺�:" + account + ",�û���:" + userName + ",��������˺ųɹ�!");
    }
	
	public void DeleteBankAccount() {
		
        System.out.print("��������Ҫɾ���������˺�:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("�����˺������ʽ����,����������!");
			return;
		}
        User user = IsUser(account);
        if(user == null){ 
            System.out.println("���˺Ų�����!");
            return;
        }else if (user.money == 0) {
    		userList.remove(user);
    		System.out.println("�����˺�Ϊ" + account + "���˻��ѳɹ�ɾ��!");
		}else {
			System.out.println("���Ƚ����˻��еĴ����ȫ��ȡ��������!");
		}
	}
	
	public void InitialAdmin() {
		Admin admins[] = new Admin[2];
		adminList = new ArrayList<Admin>();
		Admin admin = new Admin();
		admin.setAdminName("admin");
		admin.setPassword("123456");
		admins[0] = admin; 
		adminList.add(admin);
        System.out.println("����Ա�û���\t����Ա����");
        for (Admin a : adminList) {
            System.out.println(a.getAdminName() + "\t" +  "\t" + a.getPassword());
        }
	}

	public Admin IsAdmin(String adminName) {
		Admin a = null;
		for (Admin admins : adminList) {
			if (admins.adminName.equals(adminName)) {
                a = admins;
                break;
			}
        }
        return a;
	}
	
	public void BusinessSystem() {

		System.out.print("�������������˺�:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("�����˺������ʽ����,����������!");
			return;
		}
        User user = IsUser(account);
        if(user == null){    
            System.out.println("���˻�������!");
            return;
        }
        System.out.print("������������:");
        String password = input.next();
        if(!user.password.equals(password)){
            System.out.println("��������������!");
            return;
        }
		System.out.println("******��ӭ�������Ŀͻ���******");
	    System.out.println("1-�˻�����ѯ");
	    System.out.println("2-���");
	    System.out.println("3-ȡ��");
	    System.out.println("4-������ҳ��");
	    int choice = 0;  
        do{
        	System.out.println("����������Ҫ���еĲ�����");
            choice = input.nextInt(); 
            switch(choice){
                case 1:
                	CheckBalance();
                    break;
                case 2:
                	BankAddMoney();
                    break;
                case 3:
                	BankCutMoney();
                    break;
                case 4:
                	ShowMenu();
                    break;
                default:
                    System.out.println("û������Ҫ�ķ�����Ŀ,����������!");
            }    
            if(choice == 4){
                break; 
            }
        }
        while(choice != 0);
	}

	public void CheckBalance() {
		System.out.print("�����ٴ����������˺�:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("�����˺������ʽ����,����������!");
			return;
		}
        User user = IsUser(account);
        if(user == null){    
            System.out.println("���˻�������!");
            return;
        }
        
        System.out.print("������������:");
        String password = input.next();
        if(!user.password.equals(password)){
            System.out.println("��������������!");
            return;
        }
        System.out.println("�˻�������ǣ�"+user.money);
    	}

    public void BankAddMoney(){
        System.out.print("�����ٴ�����������˺�:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("�����˺������ʽ����,����������!");
			return;
		}
        User user = IsUser(account);
        if(user == null){    
            System.out.println("���˻�������!");
            return;
        }
        System.out.print("������������:");
        double addMoney = input.nextDouble();
        
        double result = user.UserAddMoney(user.getMoney(), addMoney);
        if(result == -1){
            System.out.println("���ʧ��!");
            return;
        }
            user.money =  result;
            System.out.println("���ɹ�!��ǰ���:" + result);            
    }
	
    public void BankCutMoney(){
        System.out.print("�����ٴ����������˺�:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("�����˺������ʽ����,����������!");
			return;
		}
        User user = IsUser(account); 
        if(user == null){    
            System.out.println("���˻�������!");
            return;
        }
        System.out.print("������������:");
        String password = input.next();
        if(!user.password.equals(password)){
            System.out.println("��������������!");
            return;
        }
        System.out.println("��������ȡ����:");
        double cutMoney = input.nextDouble();
        
        int i = user.UserCutMoney(cutMoney);
        if(i < 0){
            System.out.println("ȡ��ʧ��!");
        }else{
            System.out.println("ȡ��ɹ�����ǰ��"+user.money);
        }
    }
	
    public void InitialUser() {

        User users[] = new User[6];

        userList = new ArrayList<User>();

        User user = new User();
        user.setAccount("12021032073");
        user.setUserName("�ż��");
        user.setPassword("123");
        user.setId("362410200105121170");
        user.setAddress("��������ɽ");
        user.setMoney(999999);
        users[0] = user; 
        userList.add(user);

        User user1 = new User();
        user1.setAccount("12021052065");
        user1.setUserName("������");
        user1.setPassword("123");
        user1.setId("2476342004062112104");
        user1.setAddress("�����Ͼ���");
        user1.setMoney(999);
        users[1] = user1;
        userList.add(user1);

        System.out.println("�����˺�\t\t�û���\t����\t���֤��\t\t\t��ͥסַ\t\t�����");

        for (User u : userList) {
            System.out.println(u.getAccount() + "\t" + u.getUserName() + "\t" + u.getPassword() + "\t" + u.getId()
            + "\t" + u.getAddress() + "\t" + u.getMoney());
        }
    }
	
    public User IsUser(String account) {
        User u = null;
        for (User users : userList) {
            if (users.account.equals(account)) {
                u = users;
                break;
            }
        }
        return u;
    }
	
}