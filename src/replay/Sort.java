package replay;

  import java.io.EOFException;
  import java.io.File;
  import java.io.FileInputStream;
  import java.io.FileReader;
  import java.io.IOException;
  import java.io.ObjectInputStream;
  import java.nio.file.Files;
  import java.nio.file.Path;
  import java.nio.file.Paths;
  import java.nio.file.StandardCopyOption;


  public class Sort {
    /* Replay's folder path */
    final String replaysFolder = "replays/";

    /* Arrays for saving replay's names and info, like length or score */
    private int replayNames[];
    private int replayInfo[];

    private int range;

    public Sort(int range) {
      this.replayNames = new int[range];
      this.replayInfo = new int[range];
      this.range = range - 1;
    }

    public void readLengths() {
      for (int i = 0; i <= range; ++i) {
        replayNames[i] = i;

        Path replayPath = Paths.get(replaysFolder + Integer.toString(i) + ".rep");

        try (FileReader fileReader = new FileReader(replayPath.toString())) {
          int buffer = 0;
          while (buffer != -1) {
            buffer = fileReader.read();
            replayInfo[i] += 1;
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    public void readScores() throws IOException, ClassNotFoundException {
      for (int i = 0; i <= range; i++) {
        replayNames[i] = i;

        FileInputStream fileInputStream =
            new FileInputStream(replaysFolder + Integer.toString(i) + ".rep");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        State tempState = null;
        State finalState = null;

        while (true) {
          try {
            tempState = (State) objectInputStream.readObject();
          } catch (EOFException e) {
            break;
          }

          if (tempState == null) {
            break;
          } else {
            finalState = tempState;
          }
        }

       // replayInfo[i] = finalState.Score.size();

        objectInputStream.close();
        fileInputStream.close();
      }
    }

    public void javaSort() {
      long start = System.nanoTime();
      quickSort(0, range);
      long finish = System.nanoTime();
      System.out.println(" Java quick sort: " + (finish - start) + " nanoseconds");
      copySortedFiles();
    }

    private void quickSort(int firstReplayName, int lastReplayName) {
      int pivot = replayInfo[(firstReplayName + lastReplayName) / 2];
      int i = firstReplayName;
      int j = lastReplayName;

      while (i <= j) {
        while (replayInfo[i] < pivot) {
          i += 1;
        }
        while (replayInfo[j] > pivot) {
          j -= 1;
        }
        if (i <= j) {
          int tempOne = replayNames[i];
          replayNames[i] = replayNames[j];
          replayNames[j] = tempOne;

          int tempTwo = replayInfo[i];
          replayInfo[i] = replayInfo[j];
          replayInfo[j] = tempTwo;

          i++;
          j--;
        }
      }

      if (j > firstReplayName)
        quickSort(firstReplayName, j);
      if (lastReplayName > i)
        quickSort(i, lastReplayName);
    }

    public void scalaSort() {
      ScalaSort scalaSort = new ScalaSort();
      scalaSort.sort(replayNames, replayInfo, 0, range);
      copySortedFiles();
    }

    private void copySortedFiles() {
      try {
        File bestSourceFile = new File(replaysFolder + Integer.toString(replayNames[0]) + ".rep");
        File bestSortedFile = new File(replaysFolder + "BEST.rep");
        Files.copy(bestSourceFile.toPath(), bestSortedFile.toPath(),
            StandardCopyOption.REPLACE_EXISTING);
        System.out.println("okkk");

        File worstSourceFile =
            new File(replaysFolder + Integer.toString(replayNames[range]) + ".rep");
        File worstSortedFile = new File(replaysFolder + "WORST.rep");
        Files.copy(worstSourceFile.toPath(), worstSortedFile.toPath(),
            StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
