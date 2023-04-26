import styled from "styled-components";
import { useEffect, useState } from "react";
import { BtnBlueFill } from "../styles/common.js";
import { Input } from "../components/Input.jsx";
import { SignUpText } from "../components/SignUpText.jsx";
import { SignUpApi } from "../utils/api";
import useCheckInput from "../hooks/useCheckInput";
import useInput from "../hooks/useInput";
import { useNavigate } from "react-router-dom";
import BREAKPOINT from "../breakpoint.js";

const Background = styled.div`
  display: flex;
  flex-grow: 1;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  position: relative;
  width: 100vw;
  min-width: 420px;
  min-height: calc(100vh - 50px);
  background-color: #f1f2f3;
  @media screen and (max-width: ${BREAKPOINT.tablet}) {
    .side-content {
      display: none;
    }
  }
  @media screen and (min-width: ${BREAKPOINT.tablet}) {
    .top-content {
      display: none;
    }
  }
  .top-content {
    margin-bottom: 36px;
    font-size: 21px;
    text-align: center;
  }
  .view-col {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    .text {
      display: flex;
      margin-bottom: 12px;
    }
    .sub-text {
      font-size: 13px;
      margin-right: 5px;
    }
    .sub-link {
      font-weight: 500;
      font-size: 13px;
      margin-right: 5px;
      color: #0a95ff;
    }
    .icon {
      fill: #0a95ff;
    }
  }
`;
const Button = styled(BtnBlueFill)`
  width: 268px;
  height: 38.0308px;
  margin: 12px 0 8px 2px;
  font-size: 13px;
  font-weight: 700;
`;

export const SignUp = () => {
  const navigate = useNavigate();
  const [preventSubmit, setPreventSubmit] = useState(true);
  const [nickName, nicknameHandler] = useInput("");
  const [nicknameError, setNicknameError] = useState(false);
  const [email, emailHandler] = useInput("");
  const [password, passwordHandler] = useInput("");
  const [isSubmitted, setIsSubmitted] = useState(false);

  // nickname, email, password 유효성 검사 코드
  useEffect(() => {
    if (nickName === email) {
      setNicknameError(true);
    } else {
      setNicknameError(false);
    }
  }, [nickName, email]);
  const emailError = useCheckInput(
    email,
    /[a-zA-Z0-9._]+@[a-zA-Z0-9]+.[a-zA-Z0-9.]+/gm,
  );
  const passwordError = useCheckInput(
    password,
    /^(?=.*[A-Za-z])(?=.*d)[A-Za-zd]{8,}$/gm,
  );

  // 조건별 에러 메시지 저장
  const emailErrorMessage = () => {
    if (!email) {
      return "Email cannot be empty.";
    }
    if (emailError) {
      return `${email} is not a valid email address.`;
    }
    return "";
  };

  // 유효하지 않은 email, password 입력시 제출 방지를 위한 코드
  useEffect(() => {
    if (!emailError && !passwordError) {
      setPreventSubmit(false); // api 통신 활성화를 위한 상태 변경
    } else {
      setPreventSubmit(true);
      console.log(`preventSubmit ${preventSubmit}`);
    }
  }, [emailError, passwordError]);

  // 제출 버튼 클릭시 이벤트
  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsSubmitted(true); // 에러 메시지 활성화를 위한 상태변경
    const form = {
      nickName,
      email,
      password,
    };
    const response = await SignUpApi(form);
    console.log("good");
    if (response) {
      navigate("/users/login");
    }
    if (preventSubmit) return;
  };

  return (
    <Background>
      <div className="side-content">
        <SignUpText />
      </div>
      <div className="view-col">
        <h1 className="top-content">
          Create your Stack Overflow account. It’s free
          <br /> and only takes a minute.
        </h1>
        <form>
          <Input>
            <div className="container">
              <div className="title">
                Display name
                <input
                  type="text"
                  value={nickName}
                  onChange={nicknameHandler}
                  className={
                    isSubmitted && nicknameError ? "input error" : "input"
                  }
                />
                {isSubmitted && nicknameError ? (
                  <>
                    <svg
                      aria-hidden="true"
                      className="svg-icon"
                      width="18"
                      height="18"
                      viewBox="0 0 18 18"
                    >
                      <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"></path>
                    </svg>
                    <p className="error-message">
                      Name and email address must be different. If you
                      don&apos;t want to enter a name, just leave it blank.
                    </p>
                  </>
                ) : null}
              </div>
            </div>
            <div className="container">
              <div className="title">
                Email
                <input
                  type="text"
                  value={email}
                  onChange={emailHandler}
                  className={
                    isSubmitted && emailError ? "input error" : "input"
                  }
                />
                {isSubmitted && emailError ? (
                  <>
                    <svg
                      aria-hidden="true"
                      className="svg-icon"
                      width="18"
                      height="18"
                      viewBox="0 0 18 18"
                    >
                      <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"></path>
                    </svg>
                    <p className="error-message">{emailErrorMessage()}</p>
                  </>
                ) : null}
              </div>
            </div>
            <div className="container">
              <div className="title">
                Password
                <input
                  type="password"
                  value={password}
                  onChange={passwordHandler}
                  className={isSubmitted && !password ? "input error" : "input"}
                />
                {isSubmitted && !password ? (
                  <>
                    <svg
                      aria-hidden="true"
                      className="svg-icon"
                      width="18"
                      height="18"
                      viewBox="0 0 18 18"
                    >
                      <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"></path>
                    </svg>
                    <p className="error-message">Password cannot be empty.</p>
                  </>
                ) : null}
                <p className="message">
                  Passwords must contain at least eight characters, including at
                  least 1 letter and 1 number.
                </p>
              </div>
            </div>
            <Button onClick={handleSubmit}> Sign up</Button>
          </Input>
        </form>
        <div className="text">
          <div className="sub-text">Already have an account? </div>
          <div className="sub-link">Log in </div>
        </div>
        <div className="text">
          <div className="sub-text">Are you an employer? </div>
          <div className="sub-link">Sign up on Talent </div>
          <svg
            aria-hidden="true"
            width="14"
            height="14"
            viewBox="0 0 14 14"
            className="icon"
          >
            <path d="M5 1H3a2 2 0 0 0-2 2v8c0 1.1.9 2 2 2h8a2 2 0 0 0 2-2V9h-2v2H3V3h2V1Zm2 0h6v6h-2V4.5L6.5 9 5 7.5 9.5 3H7V1Z"></path>
          </svg>
        </div>
      </div>
    </Background>
  );
};
