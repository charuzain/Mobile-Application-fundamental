///* Problem 1.
//        Your program would ask a user for a website address and a String, your program should now
//        travers that site and up to 100 out bounding links from that site to find that string.
//        If it finds it just print the line and the link of address it found it in.
//        An outbound link, also called an external link, is a link from your website to a different
//        website
//        Your program should not visit the same page more than once.
//        Hint, use a link list to track all the already visited sites and to visited sites. */
//
//
//

import java.util.ArrayList;
import java.util.Scanner;

public class Web {

  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter a URL: ");
    String url = input.nextLine();

    System.out.print("Enter a string to search ");
    String stringToSearch = input.nextLine();
    crawler(url, stringToSearch);

  }

  public static void crawler(String startingURL, String stringToSearch) {
    ArrayList<String> listOfPendingURLs = new ArrayList<>();
    ArrayList<String> listOfTraversedURLs = new ArrayList<>();

    listOfPendingURLs.add(startingURL);
    while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
      String urlString = listOfPendingURLs.remove(0);
      if (!listOfTraversedURLs.contains(urlString)) {
        listOfTraversedURLs.add(urlString);
        System.out.println("Craw " + urlString);
        for (String s : getSubURLs(urlString, stringToSearch)) {

          if (!listOfTraversedURLs.contains(s))
            listOfPendingURLs.add(s);
        }
      }
    }
  }

  public static ArrayList<String> getSubURLs(String urlString, String stringToSearch) {
    ArrayList<String> list = new ArrayList<>();

    try {
      java.net.URL url = new java.net.URL(urlString);
      Scanner input = new Scanner(url.openStream());
      int current = 0;
      while (input.hasNext()) {
        String line = input.nextLine();
        if (line.contains(stringToSearch)) {
          System.out.println(stringToSearch + " found on " + url);
          System.out.println(line);

        }
        current = line.indexOf("http:", current);
        while (current > 0) {
          int endIndex = line.indexOf("\"", current);
          if (endIndex > 0) {
            list.add(line.substring(current, endIndex));
            current = line.indexOf("http:", endIndex);
          } else
            current = -1;
        }
      }
    } catch (Exception ex) {

    }

    return list;
  }
}
