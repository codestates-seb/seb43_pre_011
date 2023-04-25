import Header from "./components/Header.jsx";
import Nav from "./components/nav.jsx";
import AllQuestions from "./pages/AllQuestions.jsx";
import { Footer } from "./components/Footer.jsx";
import GlobalStyle from "./styles/GlobalStyle.js";
import styled from "styled-components";
//import AskQuestionPage from "./pages/AskQuestionP.jsx";

const StyledApp = styled.div`
  .wrapper {
    display: flex;
    margin: 0 auto;
    max-width: 126.4rem;
    width: 100%;

    & > .container {
      display: flex;
      justify-content: space-between;
      max-width: 110rem;
      width: calc(100% - 16.4rem);
      padding-top: 2.4rem;
      padding-right: 1rem;
      border-left: 1px solid var(--box-border);
    }
  }
`;

function App() {
  return (
    <>
      <GlobalStyle />
      <StyledApp className="App">
        <Header />
        <div className="wrapper">
          <Nav />
          <div className="container">
            <AllQuestions />
          </div>
        </div>
        <Footer />
      </StyledApp>
    </>
  );
}

export default App;
