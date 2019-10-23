import * as express from 'express';
import * as fs from 'fs';
import * as bodyParser from 'body-parser';
import { Request, Response } from 'express';

const app = express();
app.use(bodyParser.json());
const {
  PORT = 3000
} = process.env;
const PRELOAD_JSON = 'res/preload.json';
const PREVIEWS_JSON = 'res/previews.json';

app.get('/', (req: Request, res: Response) => {
  res.send({
    message: 'hello world!',
  })
});

app.get("/preload", (req: Request, res: Response) => {
  const data = JSON.parse(fs.readFileSync(PRELOAD_JSON, 'utf8'));
  res.send(data);
});

app.get("/getPreviewsByIds", (req: Request, res: Response) => {
  const data = JSON.parse(fs.readFileSync(PREVIEWS_JSON, 'utf8'));
  const ids = req.body.ids;
  const filteredData = data.filter(item => ids.includes(item.id));

  res.send(filteredData);
});

if (require.main === module) {
  app.listen(PORT, () => {
    console.log('server started at http://localhost:' + PORT);
  });
}

export default app;
