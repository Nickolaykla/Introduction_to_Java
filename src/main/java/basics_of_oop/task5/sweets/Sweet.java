package basics_of_oop.task5.sweets;

public abstract class Sweet {
      String name;
      double weight;

   public String getName() {
      return name;
   }

   public double getWeight() {
      return weight;
   }

   public void setWeight(double weight) {
      this.weight = weight;
   }

   @Override
   public String toString() {
      return  name + ", вес=" + weight + " гр.";
   }
}
