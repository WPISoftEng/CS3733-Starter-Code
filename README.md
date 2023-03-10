To assemble a jar file for your project, run the "distZip" gradle task, either through IntelliJ or by doing
`gradle distZip` on a terminal. Gradle will automatically download all dependencies needed to compile your zip file,
which will be stored in the build/distributions folder.

Make sure to edit the main class attribute the build.gradle file, you'll need to change it in order to obtain
a working jar file.

# Important Files
## build.gradle / gradle.properties
This is the gradle configuration file. Modify this file to add dependencies to your project. In
 general you should only modify the depedencies section of this file, however there are a few
  modification you will need to make when you begin the project
  
  - `mainClassName`
    - Modifiy this variable to point to your main class. By default it is `edu.wpi.teamname.Main
    `, but once you update your teamname package to your team letter you will need to update this
     path.
     
  - spotless
    - spotless is a style guider checker/formatter that will automatically detect if your code
     adheres to an agreed style guide. For this starter code I have defaulted to Google's style
     guide, as it is well known and well liked. You can find more documentation for spotless 
     [here](https://github.com/diffplug/spotless). If you would like to disable the spotless
      checks, comment out the spotless plugin as well as the spotless configuration at the bottom
       of the file
    

## .gitignore
This file tells git which files to ignore in the repo. It should be correctly configured already
**Only modify this file if you are sure you know what you are doing**

