import { Word2VecParams } from "./params";

export class Word2Vec {
  id: Number;
  name: String;
  algorithm: String;
  description: String;
  params: Word2VecParams
}

export class ModelDto {
  name: String;
  description: String;
  algorithm: String;
}