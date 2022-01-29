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
