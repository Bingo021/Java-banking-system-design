
public class User {

    String account;
    String userName;
    String password;
    String address;
    String id;
    double money;
        
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public double UserAddMoney(double money,double addMoney){
        if(addMoney > 0){
            money += addMoney;
            return money;
        }else{
            System.out.println("存款金额不足，请充值!");
            return -1;
        }
    }
    
    public int  UserCutMoney(double outMoney){
        if(outMoney > 0){
            if(outMoney <= money){
                money -=  outMoney;
                return 1;
            }else{
                System.out.println("取款金额不能大于账号余额！");
                return -1;
            }
        }else{
            System.out.println("取款金额不能为负数!");
            return -1;
        }
    }
}

