package replay;

class ScalaSort {
  def sort(replayNames: Array[Int], replayInfo: Array[Int],
    firstReplayName: Int, lastReplayName: Int) {

    def quickSort(firstReplayName: Int, lastReplayName: Int) {
      val pivot = replayInfo((firstReplayName + lastReplayName) / 2)
      var i = firstReplayName
      var j = lastReplayName
      while (i <= j) {
        while (replayInfo(i) < pivot) i += 1
        while (replayInfo(j) > pivot) j -= 1
        if (i <= j) {
          val temp = replayNames(i)
          replayNames(i) = replayNames(j)
          replayNames(j) = temp

          val str = replayInfo(i);
          replayInfo(i) = replayInfo(j);
          replayInfo(j) = str

          i += 1
          j -= 1
        }
      }
      if (j > firstReplayName) quickSort(firstReplayName, j)
      if (lastReplayName > i) quickSort(i, lastReplayName)
    }

    val start = System.nanoTime()
    quickSort(0, replayInfo.length - 1)
    val finish = System.nanoTime()
    System.out.println("Scala quick sort: " + (finish - start) + " nanoseconds")
  }
}