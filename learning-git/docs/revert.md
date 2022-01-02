git revert
==========

This will revert the las commit in the current branch
```
git revert HEAD
```

If the commit is a merge will need to use `-m 1` to specify the number of merges 
to revert
```
git revert HEAD
```

If you want to revert a commit specifically you can pass down the commit sha
```
git revert <commit>
```