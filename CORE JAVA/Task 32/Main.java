public class Main {
    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();
            dao.insertStudent(3, "Charlie", 23);
            dao.updateStudent(3, "Charles");
            dao.close();
            System.out.println("Operations completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
