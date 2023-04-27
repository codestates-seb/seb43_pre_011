import Header from "./components/Header.jsx";
import Nav from "./components/nav.jsx";
import { Footer } from "./components/Footer.jsx";
import AllQuestions from "./pages/AllQuestions.jsx";
import QuestionDetail from "./pages/QuestionDetail.jsx";
import { SignUp } from "./pages/SignUp.jsx";
import { Login } from "./pages/Login.jsx";
import GlobalStyle from "./styles/GlobalStyle.js";
import styled from "styled-components";
import { Route, Routes, useLocation } from "react-router-dom";
import AskQuestionP from "./pages/AskQuestionP.jsx";
import { getQuestionSelector } from "./store/index.js";
import { useRecoilValue } from "recoil";
import { Suspense } from "react";
import UpdateQuestion from "./pages/UpdateQuestion.jsx";

const StyledApp = styled.div`
  .wrapper {
    display: flex;
    margin: 0 auto;
    /* max-width: 126.4rem; */
    justify-content: center;
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
  const { pathname } = useLocation();
  const questions = useRecoilValue(getQuestionSelector);
  // console.log(questions);

  return (
    <>
      <GlobalStyle />
      <StyledApp className="App">
        <Header />
        <Suspense fallback={<div>Loading...</div>}>
          <div className="wrapper">
            {pathname === "/members" || pathname === "/users/signup" ? null : (
              <Nav />
            )}
            {/* <div className="container"> */}
            <Routes>
              <Route
                path="/"
                element={<AllQuestions questions={questions} />}
              />
              <Route path="/members" element={<SignUp />} />
              <Route path="/users/login" element={<Login />} />
              <Route path="/questions/ask" element={<AskQuestionP />} />
              <Route
                path="/questions/:questionsId"
                element={<QuestionDetail />}
              />
              <Route
                path="/questions/edit/:questionsId"
                element={<UpdateQuestion />}
              />
            </Routes>
            {/* </div> */}
          </div>
        </Suspense>
        {pathname === "/users/login" || pathname === "/users/signup" ? null : (
          <Footer />
        )}
      </StyledApp>
    </>
  );
}

export default App;
