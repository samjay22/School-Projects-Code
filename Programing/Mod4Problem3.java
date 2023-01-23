import Problem_3.*;




class Main_Driver{
//(String ClassTime, String DepartmentName, String TeacherName, String Disc, int Size)
   public static void main(String[] args){
   
      Math_101 MathClass = new Math_101("6:45am - 10:30am", "Mathmatics", "Yang Li", "Intro Mathmatics", 25);
      English_101 EnglishClass = new English_101("12:30pm - 2:45pm", "English", "Lori Alox", "Intro English", 25);
      
      System.out.println(MathClass);
      System.out.println(EnglishClass);
      
      /// Enrolling students. May have gotten carried away...
      EnglishClass.EnrollStudent("Robert Locke", 25, "English");
      EnglishClass.EnrollStudent("Jimmy Rich", 21, "Theater");
      EnglishClass.EnrollStudent("Ashley Rocker", 20, "Art");
      EnglishClass.EnrollStudent("Triste Lickir", 17, "Math");
      EnglishClass.EnrollStudent("Ying Mong", 15, "Physics");
      EnglishClass.EnrollStudent("Haven Estel", 18, "Neuro-Sci");
      EnglishClass.EnrollStudent("Zuse Braxy", 39, "Logic");
      EnglishClass.EnrollStudent("Alex Ratres", 60, "Computer Sci");
      EnglishClass.EnrollStudent("Samuel Taylor", 19, "Computer Sci and Neuro-Sci");
      
      MathClass.EnrollStudent("Robert Locke", 25, "English");
      MathClass.EnrollStudent("Jimmy Rich", 21, "Theater");
      MathClass.EnrollStudent("Ashley Rocker", 20, "Art");
      MathClass.EnrollStudent("Triste Lickir", 17, "Math");
      MathClass.EnrollStudent("Ying Mong", 15, "Physics");
      MathClass.EnrollStudent("Haven Estel", 18, "Neuro-Sci");
      MathClass.EnrollStudent("Zuse Braxy", 39, "Logic");
      MathClass.EnrollStudent("Alex Ratres", 60, "Computer Sci");
      MathClass.EnrollStudent("Samuel Taylor", 19, "Computer Sci and Neuro-Sci");
      
      //Display students
      EnglishClass.DisplayStudents();
      MathClass.DisplayStudents();
   }
}