package in.ashokit.binding;

public class Customer {

	private int cid;
	private String name;
	private String phno;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", phno=" + phno + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
}
