const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    ["/members"],
    createProxyMiddleware({
      target: "https://4256dbf9a9eb.ngrok.app",
      changeOrigin: true,
    }),
  );

  app.use(
    ["/questions"],
    createProxyMiddleware({
      target: "https://4256dbf9a9eb.ngrok.app",
      changeOrigin: true,
    }),
  );
};
