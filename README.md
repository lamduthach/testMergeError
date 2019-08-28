# testMergeError

### Explain for this Repository

When we develop with a team the old development progress we do :
Make Solution => Coding => create new Pull Request => Review => Merge master (if no conflicts - the merge mark green in git hub web) => hit merge button in github web => pull new master to prepare-deploy-machine => clean and build => Some unexpected `error` happen

This is merge button
![Capture](https://user-images.githubusercontent.com/28701735/63821731-08fcd280-c989-11e9-9a75-65dc2783cceb.PNG)

### Detail
The master code :
```java
package com.thachlam.Main;

/**
 *
 * @author Lam Du Thach
 */
public class Main {
    
    public static void main(String[] args) {
        Main m = new Main();
    }
    
    private String checkUrlResult(String url){
        return url;
    }
}

```

We have 2 issue with there Pull request and the code <br>

Name : change checkUrlResult <br>
issue : 1 <br>
pull request : 4 <br>
Description : this issue were code first, and some case it were code long time ago before issue2, but it has no conficts with master, even we merge issue2 into master first
Code : <br>
```java
package com.thachlam.Main;

/**
 *
 * @author Lam Du Thach
 */
public class Main {
    
    public static void main(String[] args) {
        Main m = new Main();
    }
    
    private String checkUrlResult(String url, String check){
        return url + check;
    }
}
```

Name : add test1() - this test1() will use old checkUrlResult <br>
issue : 2 <br>
pull request : 3 <br>
Description : This will be merge to master first before issue1 base on some priority or business, even issue1 were code long time ago
Code : <br>
```java
package com.thachlam.Main;

/**
 *
 * @author Lam Du Thach
 */
public class Main {
    
    public static void main(String[] args) {
        Main m = new Main();
    }
    
    private String checkUrlResult(String url){
        return url;
    }
    
    public String test1(){
        return checkUrlResult("this test1");
    }
}
```

We merge issue2 with pr3 into master first. The Merge button in github we show ok <br>
The new master will be : <br>
```java
package com.thachlam.Main;

/**
 *
 * @author Lam Du Thach
 */
public class Main {
    
    public static void main(String[] args) {
        Main m = new Main();
    }
    
    private String checkUrlResult(String url){
        return url;
    }
    
    public String test1(){
        return checkUrlResult("this test1");
    }
}
```

Then we switch to try merge issue1 with pr4. The `Merge button` in github web show ok, green one, no conflicts at all <br>
And of couse when we pull master again, clean and build before deploy it to server, it will throw compile error. Tada, this is unexpected error, we have to make new issue to fix it again, in rushing time with painful heart attack. <br>
But luckily, we are good team, good family, we fix it well. <br>

### temp Solution
So, now our tactical Solution will be change our development progress. <br>
Make Solution => Coding => create new Pull Request => Review => (if this issue long time ago) ask whom code issue pull master and check, clean and build again => Merge master => pull new master to prepare-deploy-machine => clean and build => deploy <br>

However, we should consider more about this problem, luckily it show up in compile error, but more over, with the test file, with might not show complile error, the compile show ok, but when run the test code or in runtime it might not ok in unexpected way. <br>

I learn that github that have some CLI checking for this problem. So hopefully forward to it, **SO HOPEFULLY**.
