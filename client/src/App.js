import Header from "./components/common/Header.jsx";
import AllQuestions from "./pages/AllQuestions.jsx";
import { Footer } from "./components/Footer.jsx";
import GlobalStyle from "./styles/GlobalStyle.js";

function App() {
  return (
    <>
      <GlobalStyle />
      <div className="App">
        <Header />
        <div className="wrapper">
          {/* 임시 */}
          <nav>네비이이이</nav>
          <div className="container">
            <AllQuestions />
          </div>
        </div>
        <Footer />
      </div>
    </>
  );
}

export default App;
