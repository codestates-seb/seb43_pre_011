// import styled from "styled-components";
import { useState } from "react";
import { BtnBlueFill } from "../styles/common.js";
import { Input } from "../components/Input.jsx";
import useCheckInput from "../hooks/useCheckInput";
import useInput from "../hooks/useInput";
import { SignUpApi } from "../utils/api";
// import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
import styled from "styled-components";

const Background = styled.div`
  /* position: relative; */
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  height: 90vh;
  background-color: "#F1F2F3";
`;
const Button = styled(BtnBlueFill)`
  width: 268px;
  height: 38.0308px;
  margin: 12px 0 8px 2px;
  font-size: 13px;
  font-weight: 700;
`;

export const SignUp = () => {
  // const navigate = useNavigate();
  const [preventSubmit, setPreventSubmit] = useState(true);
  const [nickname, nicknameHandler] = useInput("");
  const [nicknameError, setNicknameError] = useState(false);
  const [email, emailHandler] = useInput("");
  const [password, passwordHandler] = useInput("");
  const [isSubmitted, setIsSubmitted] = useState(false);

  useEffect(() => {
    if (nickname === email) {
      setNicknameError(true);
    } else {
      setNicknameError(false);
    }
  }, [nickname, email]);

  const emailError = useCheckInput(
    email,
    /[a-zA-Z0-9._]+@[a-zA-Z0-9]+.[a-zA-Z0-9.]+/gm,
  );
  const passwordError = useCheckInput(
    password,
    /^(?=.*[A-Za-z])(?=.*d)[A-Za-zd]{8,}$/gm,
  );

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsSubmitted(true);

    if (preventSubmit) return;
    const form = {
      nickname,
      email,
      password,
    };
    const response = await SignUpApi(form);
    if (response) {
      // navigate("/");
    }
  };

  useEffect(() => {
    if (!emailError && !passwordError) {
      setPreventSubmit(false);
    } else {
      setPreventSubmit(true);
    }
  }, [emailError, passwordError]);

  return (
    <Background>
      <div className="inputBg">
        {/* <InputBox> */}
        <form>
          <Input>
            <div className="container">
              <div className="title">
                Display name
                <input
                  type="text"
                  value={nickname}
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
                    <p className="error-message">
                      {email} is not a valid email address.
                    </p>
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
                  className="input"
                />
                <p className="message">
                  {" "}
                  Passwords must contain at least eight characters, including at
                  least 1 letter and 1 number.
                </p>
              </div>
            </div>
            <Button onClick={handleSubmit}> Sign up</Button>
          </Input>
        </form>
        {/* </InputBox> */}
      </div>
    </Background>
  );
};
