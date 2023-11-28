import { ConfigModuleOptions } from "@nestjs/config";
import Joi from "joi";

export const CONFIG_VALIDATOR: ConfigModuleOptions = {
  validationSchema: Joi.object({
    DB_HOST: Joi.string().required(),
  }),
  isGlobal: true,
};
