# Megagame
Source code for a Megagame

## Clean repo
**Always give explanatory commit messages (concise messages are better, but not a necessity)**

**Always create a new branch when implementing a new feature (for safety reasons)**

**When mergin a branch to the master branch, follow these steps:**
1. git checkout master
2. git pull
3. git checkout myTask
4. git rebase master (cleans up the history. Is useful when looking in the repo history)
5. git checkout master
6. git merge myTask
7. git push (= git push origin master) Push to remote repo
8. git branch -d myTask Delete branch

**(Don't forget to delete the branch at the remote as well)**

[Help for merge conflicts](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/resolving-a-merge-conflict-using-the-command-line)
---

## Running the application locally:
1. From top directory, go to *src/main/ui* and run **npm install**
2. Then run **npm start** (this starts a local server that can be accessed by localhost:4200)
3. To run the backend aswell, run in another terminal from top directory the command **mvn clean install** (can be done from ide)
4. Then run the created .jar file, which will be located in *target* (from commandline, it can be run from top directory: **java -jar target/users-0.0.1-SNAPSHOT.jar**)
5. When running the .jar file, another local server is created on port 8080 and can therefore be accessed at localhost:8080
