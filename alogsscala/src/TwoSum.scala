import scala.collection.mutable.HashMap
import scala.collection.immutable.Stream.Empty
import scala.collection.mutable

/**
  * Created by Rohit Sachan at home
  */
object TwoSum {

  def main(args: Array[String]): Unit = {
    val nums = Array(1,2,7,8,5,4)
    val target = 10

    println(twoSum(nums, target).mkString(" "))
  }


  //TODO improve with breakable
  def twoSum(nums : Array[Int], targetSum : Int ) : Array[Int] = {
    val res = new Array[Int](2)
    val holder = new mutable.HashMap[Int, Int]
    for (i <- nums.indices){
      println("iterating "+ nums(i))
      val compliment = targetSum -  nums(i)
      if(!holder.contains(compliment)){
        holder.put(nums(i),i)
      }else{
        res(0) = holder(compliment)
        res(1) = i
      }
    }
    return res
  }

}
