import scala.collection.mutable

/**
  * Created by Rohit Sachan at Home.
  */
object DuplicateNumber2 {


  /**
    * Constraint array size n && numbers cud be from [0,n-1]
    * <br> </br><b>
    *
    * Idea is to modify the original array and make entries negative at the index of number
    *
    * <br> </br></b>
    * space complexity O(1)
    * @param a
    * @return
    */
  def findDuplicate2(a: Array[Int]): Boolean = {
    for(i <- a.indices){
      if(a(Math.abs(a(i)))>=0){
        println("negating "+a(Math.abs(a(i))))
        a(Math.abs(a(i)))= -a(Math.abs(a(i)))
      }else{
        return true
      }
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1,2,3,4,2)

    println(findDuplicate2(nums))
  }

}
