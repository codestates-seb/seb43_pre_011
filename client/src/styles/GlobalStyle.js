// 전역 CSS 작성
import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

const GlobalStyle = createGlobalStyle`
/* Reset CSS */
${reset}

/* custom style */
:root {
	--link-blue:  hsl(206,100%,40%);
}

* {
  box-sizing:  border-box;
}

html {
	font-size: 62.5%;
}

body {
	font-size: 1.6rem;
}

a {
	text-decoration: none;
	color: inherit;
}

button {
	border: 0;
	background: transparent;
	padding: 0;
	cursor: pointer;
}
`;

export default GlobalStyle;
