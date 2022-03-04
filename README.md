# fluffy-telegraph

### Ideas

I was thinking it could be a chat program powered by google firebase.
I can use this as an opportunity to re-learn java.

### Install

Installing Firebase for java.

First you need SDKMAN!

```curl -s "https://get.sdkman.io" | bash```

Now install gradle

```sdk install gradle```

Finally, run the gradle command to install firebase.

```compile "com.google.firebase:firebase-admin:8.1.0"```

### Compile and run

To compile to a jar file use

```make```

To run the program, run

```make run```

If you feel like compiling it manually, here are the commands.

```
java -d build/ src/*.java
java build.main
```

I will copy any important files from /src/ to /build/

You can also run `make dev` wich calls a script called `runlog.py`
wich keeps a record of when you run the codr and if it has errors.

I can use thr log file it makes along with some screenshots 
to help me work on the code because I can't run java on my phone.
(If anyone knows how to get hava on alpine linux ley me know)
