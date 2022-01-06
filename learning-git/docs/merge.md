git merge
=========

This command allows to merge a branch a into another one
```
git merge <other_branch>
```

You can also merge a remote branch like this
```
git merge origin/other_branch
```

If you want to do a clean merge and reset the history you could you `--squash`
```
git merge richistron --squash
```