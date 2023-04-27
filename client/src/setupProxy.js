const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    ["/members", "/users", "/questions", "/vote", "/comment", "/tag"],
    createProxyMiddleware({
      target: "https://3.104.104.246",
      changeOrigin: true,
    }),
  );
};
