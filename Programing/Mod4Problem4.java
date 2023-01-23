import Problem_4.*;
//Better watch out, AMD is taking over the computer industry!

class Main{
//Computer(PartSuper CPU, PartSuper Motherboard, PartSuper PowerSupply, PartSuper GraphicsCard, PartSuper Mem, PartSuper Drive)
   public static void main(String[] args){
   
      CPU_100 CPU = new CPU_100(2.52, 125, 500.99, "AMD");
      Motherboard_100 MB = new Motherboard_100(5.55, 100, 150.99, "AMD");
      PowerSupply_100 PS = new PowerSupply_100(30.99, 100, 300.99, "AMD");
      Graphics_100 GC = new Graphics_100(30.99, 100, 300.99, "AMD");
      Mem_100 M = new Mem_100(180.25, 100, 300.99, "AMD");
      Drive_100 D = new Drive_100(99.23, 100, 300.99, "AMD");
      
      Computer NewBuild = new Computer(CPU, MB, PS, GC, M, D);
      
      System.out.println(NewBuild);
   }
}