package jdbc_oop;

public class UserApp {

	public static void main(String[] args) {
		jdbc_oop.UserDAO udao = new jdbc_oop.UserDAO();
		User uById = udao.getUserById(1);
		System.out.println(uById.toString());
		User uByName = udao.getUsersByName("cx");
		Boolean uValidate = udao.validateUser("ada","efdwedew");
		Boolean updateUser = udao.updateUser("sfwe","sfew","fdewdw");
	}

}
