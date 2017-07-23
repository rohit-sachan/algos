import scala.collection.immutable.HashMap
import scala.collection.mutable

/**
  * Created by rohit sachan at home.
  */
object DuplicateNumber {

  /**
    * Space complexity O(n)
    * @param nums
    * @return
    */
  def findDuplicate(nums: Array[Int]): Boolean = {
    val values = mutable.HashSet[Int]()
    for(i <- nums.indices){
      if (!values.add(nums(i))){
        return true
      }
    }
    false
  }

  def main(args: Array[String]): Unit = {
//    val nums = Array(1,2,7,8,4,5,4)
    val nums = Array(1,2,7,8,5,4)

    println(findDuplicate(nums))
  }

}
