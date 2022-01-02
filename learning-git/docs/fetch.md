git fetch
=========

The fetch command allows to pull remote branches locally
```
git fetch --all
```

Using `--prune` will delete local branches that have been removed remotely
```
git fetch --all --prune
```

Using fetch with no params will pull the latest changes from the current branch
```
git fetch
```