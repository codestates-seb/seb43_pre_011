import Header from "./components/Header.jsx";
import Nav from "./components/nav.jsx";
import { Footer } from "./components/Footer.jsx";
import AllQuestions from "./pages/AllQuestions.jsx";
import AskQuestionPage from "./pages/AskQuestionP.jsx";
import UpdateQuestion from "./pages/UpdateQuestion.jsx";
import { SignUp } from "./pages/SignUp.jsx";
import { Login } from "./pages/Login.jsx";
import GlobalStyle from "./styles/GlobalStyle.js";
import styled from "styled-components";
import { Route, Routes, useLocation } from "react-router-dom";

const StyledApp = styled.div`
  .wrapper {
    display: flex;
    margin: 0 auto;
    /* max-width: 126.4rem; */
    width: 100%;

    /* & > .container {
      display: flex;
      justify-content: space-between;
      max-width: 110rem;
      width: calc(100% - 16.4rem);
      padding-top: 2.4rem;
      padding-right: 1rem;
      border-left: 1px solid var(--box-border);
    } */
  }
`;

function App() {
  const { pathname } = useLocation();

  return (
    <>
      <GlobalStyle />
      <StyledApp className="App">
        <Header />
        <div className="wrapper">
          {pathname === "/users/login" ||
          pathname === "/users/signup" ||
          pathname === "/members" ? null : (
            <Nav />
          )}

          <Routes>
            <Route path="/" element={<AllQuestions />} />
            <Route path="/questions" element={<UpdateQuestion />} />
            <Route path="/members" element={<SignUp />} />
            <Route path="/users/login" element={<Login />} />
            <Route
              path="/questions/:questionId "
              element={<AskQuestionPage />}
            />
          </Routes>
        </div>
        {pathname === "/users/login" || pathname === "/users/signup" ? null : (
          <Footer />
        )}
      </StyledApp>
    </>
  );
}

export default App;
