import Header from "./components/common/Header.jsx";
// import AllQuestions from "./pages/AllQuestions.jsx";
// import Nav from "./components/nav.jsx";
// import { Footer } from "./components/Footer.jsx";
import { SignUp } from "./pages/SignUp.jsx";
import GlobalStyle from "./styles/GlobalStyle.js";

function App() {
  return (
    <>
      <GlobalStyle />
      <div className="App">
        <Header />
        <div className="wrapper">
          {/* <Nav /> */}
          <div className="container">{/* <AllQuestions /> */}</div>
          <SignUp />
        </div>
        {/* <Footer /> */}
      </div>
    </>
  );
}

export default App;
