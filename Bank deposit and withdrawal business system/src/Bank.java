import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPasswordField;

public class Bank {
	Scanner input = new Scanner(System.in);
	List<User> userList = new ArrayList<User>();
	List<Admin> adminList = new ArrayList<Admin>();
	
	public void ShowMenu(){		        
		System.out.println("-------欢迎进入存取款业务系统-------");
	    System.out.println("1-进入系统管理员子系统");
	    System.out.println("2-进入存取款子系统");
	    System.out.println("3-退出");
	    int choice = 0;  
        do{
        	System.out.println("请输入您想要进行的操作：");
            choice = input.nextInt(); 
            switch(choice){
                case 1:
                	Administrator();
                    break;
                case 2:
                	BusinessSystem();
                    break;
                case 3:
                	 System.out.println("感谢您的使用,欢迎下次光临!");
                    break;
                default:
                    System.out.println("没有您需要的服务项目,请重新输入!");
            }    
            if(choice == 3){
                break; 
            }
        }
        while(choice != 0);
    }

	public void Administrator() {
		
		System.out.print("请输入管理员用户名:");
        String adminName = input.next();
        Admin admin = IsAdmin(adminName);
        if(admin == null){    
            System.out.println("该管理员不存在!");
            return;
        }
        
        System.out.print("请输入管理员密码:");
        String password = input.next();
        if(!admin.password.equals(password)){
            System.out.println("您密码输入有误!");
            return;
        }
        System.out.println("******欢迎您：系统管理员！******");
	    System.out.println("1-添加银行账号信息");
	    System.out.println("2-删除银行账号信息");
	    System.out.println("3-返回主页面");
	    int choice = 0;  
        do{
        	System.out.println("请输入您想要进行的操作：");
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
                    System.out.println("没有您需要的服务项目,请重新输入!");
            }    
            if(choice == 3){
                break; 
            }
        }
        while(choice != 0);
	}
	
	public void AddBankAccount() {
		User u = new User();
		
        System.out.print("请您输入要添加的银行账号:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("银行账号输入格式不对,请重新输入!");
			return;
		}
        User user = IsUser(account);
        if(user != null){    
            System.out.println("该账号已存在!");
            return;
        }else {
			u.setAccount(account);
		}
        System.out.print("请您设置密码:");
        String password = input.next();
        System.out.println("请您确认密码:");
        String password1 = input.next();
        if(!password.equals(password1)){
            System.out.println("您两次密码输入不一致!");
            return;
        }else {
            u.setPassword(password);
		}
        
        System.out.print("请您输入身份证号:");
        String id = input.next();
        u.setId(id);
        System.out.print("请您输入用户名:");
        String userName = input.next();
        u.setUserName(userName);
        System.out.print("请您输入家庭住址:");
        String address = input.next();
        u.setAddress(address);
        System.out.print("请您输入存款金额:");
        int money = input.nextInt();
        u.setMoney(money);
        userList.add(u);
        System.out.println("银行账号:" + account + ",用户名:" + userName + ",添加银行账号成功!");
    }
	
	public void DeleteBankAccount() {
		
        System.out.print("请您输入要删除的银行账号:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("银行账号输入格式不对,请重新输入!");
			return;
		}
        User user = IsUser(account);
        if(user == null){ 
            System.out.println("该账号不存在!");
            return;
        }else if (user.money == 0) {
    		userList.remove(user);
    		System.out.println("银行账号为" + account + "的账户已成功删除!");
		}else {
			System.out.println("请先将该账户中的存款金额全部取出再销户!");
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
        System.out.println("管理员用户名\t管理员密码");
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

		System.out.print("请您输入银行账号:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("银行账号输入格式不对,请重新输入!");
			return;
		}
        User user = IsUser(account);
        if(user == null){    
            System.out.println("该账户不存在!");
            return;
        }
        System.out.print("请您输入密码:");
        String password = input.next();
        if(!user.password.equals(password)){
            System.out.println("您密码输入有误!");
            return;
        }
		System.out.println("******欢迎您：尊贵的客户！******");
	    System.out.println("1-账户余额查询");
	    System.out.println("2-存款");
	    System.out.println("3-取款");
	    System.out.println("4-返回主页面");
	    int choice = 0;  
        do{
        	System.out.println("请输入您想要进行的操作：");
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
                    System.out.println("没有您需要的服务项目,请重新输入!");
            }    
            if(choice == 4){
                break; 
            }
        }
        while(choice != 0);
	}

	public void CheckBalance() {
		System.out.print("请您再次输入银行账号:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("银行账号输入格式不对,请重新输入!");
			return;
		}
        User user = IsUser(account);
        if(user == null){    
            System.out.println("该账户不存在!");
            return;
        }
        
        System.out.print("请您输入密码:");
        String password = input.next();
        if(!user.password.equals(password)){
            System.out.println("您密码输入有误!");
            return;
        }
        System.out.println("账户的余额是："+user.money);
    	}

    public void BankAddMoney(){
        System.out.print("请您再次输入存银行账号:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("银行账号输入格式不对,请重新输入!");
			return;
		}
        User user = IsUser(account);
        if(user == null){    
            System.out.println("该账户不存在!");
            return;
        }
        System.out.print("请您输入存款金额:");
        double addMoney = input.nextDouble();
        
        double result = user.UserAddMoney(user.getMoney(), addMoney);
        if(result == -1){
            System.out.println("存款失败!");
            return;
        }
            user.money =  result;
            System.out.println("存款成功!当前余额:" + result);            
    }
	
    public void BankCutMoney(){
        System.out.print("请您再次输入银行账号:");
        String account = input.next();
        if (account.length() != 11) {
			System.out.println("银行账号输入格式不对,请重新输入!");
			return;
		}
        User user = IsUser(account); 
        if(user == null){    
            System.out.println("该账户不存在!");
            return;
        }
        System.out.print("请您输入密码:");
        String password = input.next();
        if(!user.password.equals(password)){
            System.out.println("您密码输入有误!");
            return;
        }
        System.out.println("请您输入取款金额:");
        double cutMoney = input.nextDouble();
        
        int i = user.UserCutMoney(cutMoney);
        if(i < 0){
            System.out.println("取款失败!");
        }else{
            System.out.println("取款成功！当前余额："+user.money);
        }
    }
	
    public void InitialUser() {

        User users[] = new User[6];

        userList = new ArrayList<User>();

        User user = new User();
        user.setAccount("12021032073");
        user.setUserName("张嘉灏");
        user.setPassword("123");
        user.setId("362410200105121170");
        user.setAddress("江西井冈山");
        user.setMoney(999999);
        users[0] = user; 
        userList.add(user);

        User user1 = new User();
        user1.setAccount("12021052065");
        user1.setUserName("李卫国");
        user1.setPassword("123");
        user1.setId("2476342004062112104");
        user1.setAddress("江苏南京市");
        user1.setMoney(999);
        users[1] = user1;
        userList.add(user1);

        System.out.println("银行账号\t\t用户名\t密码\t身份证号\t\t\t家庭住址\t\t存款金额");

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