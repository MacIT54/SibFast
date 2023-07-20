## Run from buildPath

npm start

I encountered the same issue, Surprisingly it works fine in Windows but failed in Linux giving the same error. Follow below step to resolve this issue.

you need to change package.json file inside your project folder like below instead of default value of "start": "react-scripts start"

"scripts": { "start": "node ./node_modules/react-scripts/bin/react-scripts.js start" }
Test string
