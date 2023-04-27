const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    ["/members", "/users", "/questions", "/vote", "/comment", "/tag"],
    createProxyMiddleware({
      target: "https://4256dbf9a9eb.ngrok.app",
      changeOrigin: true,
    }),
  );
};
