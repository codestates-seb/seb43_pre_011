const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    ["/members"],
    createProxyMiddleware({
      target: "https://f6b6b9ce4c90.ngrok.app",
      changeOrigin: true,
    }),
  );
};
