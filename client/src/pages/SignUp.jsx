import styled from "styled-components";
import { BtnBlueFill } from "../styles/common.js";
import useCheckInput from "../hooks/useCheckInput";
import useInput from "../hooks/useInput";
import { SignUpApi } from "../utils/api";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";

export const SignUp = () => {
  const navigate = useNavigate();
  const [preventSubmit, setPreventSubmit] = useState(true);
  const [nickname, nicknameHandler] = useInput("");
  const [email, emailHandler] = useInput("");
  const [password, passwordHandler] = useInput("");
  const emailError = useCheckInput(
    email,
    /[a-zA-Z0-9._]+\@[a-zA-Z0-9]+\.[a-zA-Z0-9.]+/gm,
  );
  const passwordError = useCheckInput(
    password,
    /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/gm,
  );

  const handleSubmit = async () => {
    if (preventSubmit) return;
    const form = {
      nickname,
      email,
      password,
    };
    const response = await SignUpApi(form);
  };
  if (response) {
    navigate("/");
  }

  useEffect(() => {
    if (!emailError && !passwordError) {
      setPreventSubmit(false);
    } else {
      setPreventSubmit(true);
    }
  }, [emailError, passwordError]);
};
